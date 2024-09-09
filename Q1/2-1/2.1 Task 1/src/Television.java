public class Television {
    private int currentChannel;
    private boolean isOn;

    public Television() {
        this.currentChannel = 1;
        this.isOn = false;
    }

    public void setChannel(int channel) {
        if (channel > 10) {
            this.currentChannel = 1;
        } else {
            this.currentChannel = channel;
        }
    }

    public int getChannel() {
        return this.currentChannel;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void pressOnOff() {
        this.isOn = !this.isOn;
    }
}
