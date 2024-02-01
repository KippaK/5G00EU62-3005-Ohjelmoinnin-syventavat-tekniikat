import java.lang.Comparable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Category {
    private String category;

    public Category(String category) {
        setCategory(category);    
    }

    public void setCategory(String category) {
        final int maxLength = 50;
        int length;
        try {
            length = category.length();
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Category can't be null");        
        }
        length = category.length();
        if (length < 1) {
            throw new IllegalArgumentException("Category can't be empty");
        }
        if (length > maxLength) {
            throw new IllegalArgumentException("Category can't be over 50 characters long");
        }
        Pattern pattern = Pattern.compile("[a-z]*");
        Matcher isValid = pattern.matcher(category);
        if (!isValid.find()) {
            throw new IllegalArgumentException("Category can only contain lowercase letters");
        }
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}
