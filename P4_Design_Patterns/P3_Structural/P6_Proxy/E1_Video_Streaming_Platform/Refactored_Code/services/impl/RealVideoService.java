package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services.impl;

import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models.UserTypes;
import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models.VideoMetadata;
import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services.VideoService;

public class RealVideoService implements VideoService {
    @Override
    public void playVideo(String videoName, UserTypes userType) {
        System.out.println("Playing video: " + videoName);
    }

    public void loadVideoFromServer(VideoMetadata metadata) {
        System.out.println("Loading video from remote server: " + metadata.getVideoName());
        try {
            Thread.sleep(2000); // simulate heavy loading
            metadata.setIsCached(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
