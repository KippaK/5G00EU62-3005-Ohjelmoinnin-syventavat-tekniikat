public class Category
{
    public string Primary { get; }
    public string Secondary { get; }

    public Category(string primary, string secondary = "")
    {
        Primary = primary;
        Secondary = secondary;
    }

    public override string ToString()
    {
        return string.IsNullOrEmpty(Secondary) ? Primary : $"{Primary}/{Secondary}";
    }
}