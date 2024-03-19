public class Description
{
    public string Value { get; }

    public Description(string value)
    {
        if (string.IsNullOrEmpty(value))
        {
            throw new ArgumentException("Description cannot be null or empty");
        }
        if (value.Length > 500)
        {
            throw new ArgumentException("Description is too long");
        }
        Value = value;
    }

    public override string ToString()
    {
        return Value;
    }
}