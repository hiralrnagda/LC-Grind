class Logger {
    Map<String, Integer> messageLasts;

    public Logger() {
        messageLasts = new HashMap();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageLasts.containsKey(message)) {
            messageLasts.put(message, timestamp);
            return true;
        }

        int lastTimestamp = messageLasts.get(message);
        if (timestamp - lastTimestamp < 10) {
            return false;
        }
        messageLasts.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */