package exerciseone.firstscreen.model;

import javax.annotation.PostConstruct;

public class BodyOutput {
    private String bodyOutputContent;
    private String bodyToggleOutputButtonLabel;
    private Boolean activeLabel;

    public String getBodyOutputContent() {
        return bodyOutputContent;
    }

    public void setBodyOutputContent(String bodyOutputContent) {
        this.bodyOutputContent = bodyOutputContent;
    }

    public String getBodyToggleOutputButtonLabel() {
        return bodyToggleOutputButtonLabel;
    }

    public void setBodyToggleOutputButtonLabel(String bodyToggleOutputButtonLabel) {
        this.bodyToggleOutputButtonLabel = bodyToggleOutputButtonLabel;
    }

    public Boolean isActiveLabel() {
        return activeLabel;
    }

    public void setActiveLabel(Boolean activeLabel) {
        this.activeLabel = activeLabel;
    }

    @PostConstruct
    private void init() {
        this.bodyToggleOutputButtonLabel = "Checkbox";
        this.activeLabel = Boolean.TRUE;
    }
}
