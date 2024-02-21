public class EventCategory
{
    private string primary = "empty";
    private string ?secondary;

    public string Primary
    {
        get => primary;
        set
        {
            ArgumentNullException.ThrowIfNullOrEmpty(value);

            if (value.Length > 50)
            {
                throw new ArgumentException("Primary category is too long");
            }

            primary = value.ToLower();
        }
    }

    public string Secondary
    {
        get => secondary;

        set
        {
            if (!string.IsNullOrEmpty(value) && value.Length > 50)
            {
                throw new ArgumentException("Secondary category is too long");
            }

            secondary = value?.ToLower();
        }
    }

    public override string ToString()
    {
        return string.IsNullOrEmpty(Secondary) ? Primary : $"{Primary}/{Secondary}";
    }
}