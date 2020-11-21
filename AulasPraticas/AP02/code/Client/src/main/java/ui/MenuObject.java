package ui;

public final class MenuObject {
    private final String description;
    private final Runnable runnable;

    public MenuObject(String description, Runnable runnable) {
        this.description = description;
        this.runnable = runnable;
    }

    public final String getDescription() {
        return description;
    }

    public final Runnable getRunnable() {
        return runnable;
    }
}
