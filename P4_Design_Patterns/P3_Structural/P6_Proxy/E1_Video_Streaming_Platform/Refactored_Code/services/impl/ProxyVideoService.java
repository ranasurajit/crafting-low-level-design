package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services.impl;

import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models.UserTypes;
import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models.VideoMetadata;
import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services.OTTService;
import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services.VideoService;

public class ProxyVideoService implements VideoService {
    private RealVideoService realVideoService;
    private OTTService ottService;

    public ProxyVideoService(OTTService ottService) {
        if (ottService == null) {
            throw new IllegalArgumentException("OTT Service cannot be null!");
        }
        this.ottService = ottService;
        this.realVideoService = new RealVideoService();
    }

    @Override
    public void playVideo(String videoName, UserTypes userType) {
        VideoMetadata metadata = ottService.getMediaInformation(videoName);
        if (metadata == null) {
            throw new IllegalArgumentException(
                    "No such video with label : " + videoName + " exists. Please try again!");
        }
        if (metadata.getIsPremium() && userType == UserTypes.FREE_USER) {
            System.out.println(videoName + " is a premium category video. The user has no access to it!");
            return;
        }
        if (!metadata.getIsCached()) {
            realVideoService.loadVideoFromServer(metadata);
        }
        realVideoService.playVideo(videoName, userType);
    }
}
