package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code;

import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.models.UserTypes;
import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services.OTTService;
import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Refactored_Code.services.impl.ProxyVideoService;

public class Client {
    public static void main(String[] args) {
        OTTService ottService = new OTTService();
        ottService.addVideos("movie1.mp4", false);
        ottService.addVideos("premium_movie.mp4", true);

        ProxyVideoService service = new ProxyVideoService(ottService);
        service.playVideo("movie1.mp4", UserTypes.FREE_USER);
        service.playVideo("premium_movie.mp4", UserTypes.FREE_USER);
        service.playVideo("premium_movie.mp4", UserTypes.LICENSED_USER);
    }
}
