\C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\Kit485_AAB_BuildLog.txt = "C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\coin_history_audit.csv"
\ = @()
\ += "timestamp,userId,source,type,amount,balance"

\ += "2025-07-21T13:01:00Z,demoUser,OfferToro,earn,8,8"
\ += "2025-07-21T13:05:21Z,demoUser,DailyRaffle,entry,-2,6"
\ += "2025-07-21T13:07:59Z,demoUser,Referral,earn,5,11"
\ += "2025-07-21T13:11:12Z,demoUser,Cashout,spend,-10,1"

\ | Set-Content -Encoding UTF8 \C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\Kit485_AAB_BuildLog.txt
Write-Host "User coin history audit exported to: \C:\Users\leona\VS_Projects\AdForge_Android3\build_logs\Kit485_AAB_BuildLog.txt"
