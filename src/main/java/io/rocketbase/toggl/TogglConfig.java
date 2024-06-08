package io.rocketbase.toggl;

public record TogglConfig(String baseUrl, String apiToken) {
    public static final String TOGGLE_API = "https://api.track.toggl.com";

    public TogglConfig(String apiToken) {
        this(TOGGLE_API, apiToken);
    }
}
