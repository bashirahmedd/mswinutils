# Check and Start Windows Time Service with Permission Handling
# Write-Host "Checking Windows Time service..."

# try {
#     $timeService = Get-Service -Name "w32time" -ErrorAction Stop

#     if ($timeService.Status -ne "Running") {
#         Write-Host "Windows Time service is not running. Attempting to start..."
#         Set-Service -Name "w32time" -StartupType Automatic -ErrorAction Stop
#         Start-Service -Name "w32time" -ErrorAction Stop
#         Write-Host "Windows Time service started successfully."
#     } else {
#         Write-Host "Windows Time service is already running."
#     }
# } catch {
#     Write-Host "Error: $($_.Exception.Message)"
#     Write-Host "Ensure you have administrator privileges and the correct permissions to manage the service."
#     Write-Host "Proceeding with current system time."
# }

# Sync system time
# Write-Host "Syncing system time with time server..."
# w32tm /resync
# if ($LASTEXITCODE -eq 0) {
#     Write-Host "Time successfully synced."
# } else {
#     Write-Host "Failed to sync time. Proceeding with current system time."
# }

Write-Host "Make sure time is synced..."
# Adjust Brightness
$currentHour = (Get-Date).Hour
if ($currentHour -ge 8 -and $currentHour -lt 16) {
    $desiredBrightness = 60
} else {
    $desiredBrightness = 30
}

# Get WMI Class for Monitor Brightness
$brightnessMethods = Get-WmiObject -Namespace root\wmi -Class WmiMonitorBrightnessMethods

foreach ($method in $brightnessMethods) {
    $method.WmiSetBrightness(1, $desiredBrightness)
}

Write-Host "Brightness set to $desiredBrightness% based on the current time."
