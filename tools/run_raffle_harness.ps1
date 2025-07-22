\C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\Kit485_AAB_BuildLog.txt = "C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\raffle_harness_simulation.txt"
\ = @()
\ += "Simulating 1000 raffle entries across 4 types..."

for (\ = 1; \ -le 1000; \++) {
    \ = switch (\ %% 4) {
        0 { "Breadloop" }
        1 { "DailyCapped" }
        2 { "Tiered21Day" }
        3 { "CrewShowdown" }
    }
    \ += "2025-07-21T12::00Z,user,\,entered"
}

\ | Set-Content -Encoding UTF8 \C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\Kit485_AAB_BuildLog.txt
Write-Host "Raffle simulation complete. Log saved to: \C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\Kit485_AAB_BuildLog.txt"
