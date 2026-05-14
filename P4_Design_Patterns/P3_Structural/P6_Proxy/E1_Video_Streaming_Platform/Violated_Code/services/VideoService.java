package P4_Design_Patterns.P3_Structural.P6_Proxy.E1_Video_Streaming_Platform.Violated_Code.services;

public class VideoService {
    public void playVideo(String videoName, String userType) {
        loadVideoFromServer(videoName);
        System.out.println("Playing video: " + videoName);
    }

    private void loadVideoFromServer(String videoName) {
        System.out.println("Loading video from remote server: " + videoName);
        try {
            Thread.sleep(2000); // simulate heavy loading
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
