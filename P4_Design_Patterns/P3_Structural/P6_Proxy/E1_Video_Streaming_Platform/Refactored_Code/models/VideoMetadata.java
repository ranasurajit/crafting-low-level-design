package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models;

public class VideoMetadata {
    private String videoName;
    private boolean isCached;
    private boolean isPremium;

    public VideoMetadata(String videoName, boolean isCached, boolean isPremium) {
        this.videoName = videoName;
        this.isCached = isCached;
        this.isPremium = isPremium;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public void setIsCached(boolean cached) {
        this.isCached = cached;
    }

    public boolean getIsCached() {
        return this.isCached;
    }

    public boolean getIsPremium() {
        return this.isPremium;
    }
}
