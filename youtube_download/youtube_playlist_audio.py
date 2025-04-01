import yt_dlp as youtube_dl
import os
import time
import re
import logging

# Clear the log file at the beginning of each execution
with open('download_debug.log', 'w'):
    pass

# Configure logging
logging.basicConfig(filename='download_debug.log', level=logging.DEBUG, format='%(asctime)s - %(levelname)s - %(message)s')

def get_playlist_video_ids(playlist_url):
    """Extract all video IDs from a YouTube playlist in order."""
    ydl_opts = {
        'extract_flat': 'in_playlist',  # Get playlist metadata without downloading videos
        'quiet': True,                 # Suppress logs
        'ignoreerrors': True,           # Skip unavailable videos
        'playlistend': 1000             # Increase if your playlist has >1000 videos
    }
    
    try:
        with youtube_dl.YoutubeDL(ydl_opts) as ydl:
            result = ydl.extract_info(playlist_url, download=False)
            return [entry['id'] for entry in result['entries'] if entry.get('id')]
        
    except Exception as e:
        print(f"Error fetching playlist: {e}")
        return []

def download_audio(video_ids):
    """Download audio files one by one with sequential numbering."""
    if not video_ids:
        print("No videos found in playlist.")
        return

    total_videos = len(video_ids)
    num_digits = len(str(total_videos))  # Determine padding for numbering (e.g., 001, 010, 100)

    # Create downloads folder if it doesn't exist
    os.makedirs(playlistID, exist_ok=False)

    for idx, video_id in enumerate(video_ids, 1):
        url = f"https://youtube.com/watch?v={video_id}"
        ydl_opts = {
            'format': 'bestaudio/best',
            'postprocessors': [{
                'key': 'FFmpegExtractAudio',
                'preferredcodec': 'mp3',       # Change to m4a/opus if needed
                'preferredquality': '192',
            }],
            'outtmpl': f'{playlistID}/{idx:0{num_digits}d} - %(title)s.%(ext)s',  # Numbered prefix
            'quiet': False,
            'ignoreerrors': True,               # Skip failed downloads
            'noprogress': False,
        }

        try:
            print(f"\nDownloading {idx}/{total_videos}: {video_id}")
            with youtube_dl.YoutubeDL(ydl_opts) as ydl:
                ydl.download([url])
                time.sleep(5)
        except Exception as e:
            logging.error(f"Failed to download {video_id}: {e}")    # Log errors to file

# Usage
playlistID="PLy4OcwImJzBLV-PKazKbw82ShgtcWy5E3"
playlist_url = "https://www.youtube.com/playlist?list=" + playlistID
video_ids = get_playlist_video_ids(playlist_url)
download_audio(video_ids)