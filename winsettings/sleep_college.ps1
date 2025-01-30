# Set Windows Power Settings Based on Argument


try {
    Write-Host "Preventing sleep and display turn-off when plugged in..."
    powercfg /change standby-timeout-ac 0
    powercfg /change monitor-timeout-ac 0
    Write-Host "Settings updated: The PC and monitor will not go to sleep while on AC power. Volume is muted."
}
catch {
    Write-Host "Error updating sleep settings: $_"
}

. "$PSScriptRoot\helper\volume_mute.ps1"
. "$PSScriptRoot\helper\brighness_morning_evening.ps1"

#.\myscript.ps1 -username "John" -age "thirty" 
