package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services;

import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models.UserTypes;

public interface VideoService {
    public abstract void playVideo(String videoName, UserTypes userType);
}
