package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services;

import java.util.HashMap;

import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models.VideoMetadata;

public class OTTService {
    HashMap<String, VideoMetadata> videoMap;

    public OTTService() {
        this.videoMap = new HashMap<>();
    }

    public void addVideos(String name, boolean isPremium) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Video name cannot be null or empty!");
        }
        videoMap.put(name, new VideoMetadata(name, false, isPremium));
    }

    public VideoMetadata getMediaInformation(String videoName) {
        return videoMap.getOrDefault(videoName, null);
    }
}
