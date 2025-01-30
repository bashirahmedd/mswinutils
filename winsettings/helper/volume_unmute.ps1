
try{
    # Path to NirCmd executable
    . "$PSScriptRoot\volume_inc.ps1"
    
    # Unmute the system volume
    Start-Process -FilePath $nircmdPath -ArgumentList "mutesysvolume 0"
}
catch{
    Write-Host "Error: $($_.Exception.Message)"
}
