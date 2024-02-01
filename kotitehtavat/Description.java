public class Description {
    private String description;

    public Description(String description) {
        setDescription(description);
    }

    public void setDescription(String description) {
        int length;
        final int maxLength = 500;
        try {
            length = description.length();
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Description can't be null"); 
        }
        length = description.length();
        if (length < 1) {
            throw new IllegalArgumentException("Description can't be empty");
        }
        if (length > 500) {
            throw new IllegalArgumentException("Description can't be over 500 characters long");
        }
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return description;
    }
}
