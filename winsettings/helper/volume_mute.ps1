try {
    # # Path to NirCmd executable
    # $nircmdPath = "C:\MyUtilityApp\nircmd-x64\nircmd.exe"
    . "$PSScriptRoot\volume_inc.ps1"

    # Mute the system volume
    Start-Process -FilePath $nircmdPath -ArgumentList "mutesysvolume 1"
}
catch {
     Write-Host "Error muting speaker : $($_.Exception.Message)"
}