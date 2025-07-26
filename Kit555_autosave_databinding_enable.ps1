# Kit555_autosave_databinding_enable.ps1
$projectRoot = "C:\Users\leona\VS_Projects\AdForge_Android3"
$gradleFile = Join-Path $projectRoot "app\build.gradle.kts"
$logFile = Join-Path $projectRoot "build_logs\Kit555_gradle.txt"
$logErrFile = Join-Path $projectRoot "build_logs\Kit555_gradle.txt.err"
$backupPath = "$gradleFile.bak_555"

# Backup
Copy-Item -Path $gradleFile -Destination $backupPath -Force

# Inject dataBinding if needed
$content = Get-Content -Path $gradleFile
$androidLine = ($content | Select-String -Pattern "android\s*\{" -SimpleMatch).LineNumber

if ($androidLine -gt 0) {
    $injection = @(
        "    buildFeatures {",
        "        dataBinding = true",
        "    }"
    )
    $before = $content[0..$androidLine]
    $after = $content[($androidLine + 1)..($content.Length - 1)]
    $patched = $before + $injection + $after
    Set-Content -Path $gradleFile -Value $patched -Encoding UTF8
} else {
    Write-Host "android { block not found"
    exit 1
}

# Build with redirection
Push-Location $projectRoot
Start-Process -FilePath "./gradlew.bat" -ArgumentList "build" `
  -RedirectStandardOutput $logFile `
  -RedirectStandardError $logErrFile `
  -NoNewWindow -Wait
Pop-Location
