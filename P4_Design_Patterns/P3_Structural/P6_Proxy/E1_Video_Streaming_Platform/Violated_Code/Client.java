package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Violated_Code;

import P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Violated_Code.services.VideoService;

public class Client {
    public static void main(String[] args) {
        VideoService service = new VideoService();

        service.playVideo("movie1.mp4", "FREE_USER");
        service.playVideo("premium_movie.mp4", "FREE_USER");
        service.playVideo("premium_movie.mp4", "PAID_USER");
    }
}
