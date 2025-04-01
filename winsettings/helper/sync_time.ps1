try {
    Write-Host "Synchronizing system time with the time server..."
    w32tm /resync
    Write-Host "System time synchronized successfully."
}
catch {
    Write-Host "Error synchronizing system time: $_"
}