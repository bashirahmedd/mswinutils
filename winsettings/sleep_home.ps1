# Set Windows Power Settings Based on Argument


try {
    Write-Host "Setting sleep and display turn-off to 20 and 10 minutes when plugged in..."
    powercfg /change standby-timeout-ac 20
    powercfg /change monitor-timeout-ac 10

    Write-Host "Settings updated: The PC and monitor will sleep after 20 and 10 minutes respectively while on AC power."
}
catch {
    Write-Host "Error updating power settings: $_"
}

. "$PSScriptRoot\helper\volume_unmute.ps1"
. "$PSScriptRoot\helper\brighness_morning_evening.ps1"

#.\myscript.ps1 -username "John" -age "thirty" 