Write-Host "Make sure time is synced..."
# Adjust Brightness
$currentHour = (Get-Date).Hour
if ($currentHour -ge 8 -and $currentHour -lt 19) {
    $desiredBrightness = 70
} else {
    $desiredBrightness = 52
}

# Get WMI Class for Monitor Brightness
$brightnessMethods = Get-WmiObject -Namespace root\wmi -Class WmiMonitorBrightnessMethods

foreach ($method in $brightnessMethods) {
    $method.WmiSetBrightness(1, $desiredBrightness)
}

Write-Host "Brightness set to $desiredBrightness% based on the current time."
