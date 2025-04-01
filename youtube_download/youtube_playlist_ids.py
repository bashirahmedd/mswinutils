import youtube_dl

def get_video_ids(playlist_url):
    ydl_opts = {
        "quiet": True,  # Suppress output
        "extract_flat": "in_playlist",  # Extract playlist metadata only
    }

    with youtube_dl.YoutubeDL(ydl_opts) as ydl:
        result = ydl.extract_info(playlist_url, download=False)
        return [video["id"] for video in result["entries"]]

playlist_url = "https://www.youtube.com/playlist?list=PLy4OcwImJzBLV-PKazKbw82ShgtcWy5E3"  # Replace with your URL
video_ids = get_video_ids(playlist_url)
print("Video IDs:", video_ids)