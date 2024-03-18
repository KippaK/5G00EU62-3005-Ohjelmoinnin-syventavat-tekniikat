using Avalonia;
using Avalonia.Controls;
using Avalonia.Media;

namespace SimpleAvaloniaApp
{
    public class App : Application
    {
        public override void Initialize()
        {
            MainWindow mainWindow = new MainWindow();
            mainWindow.Show();
        }
    }

    public class MainWindow : Window
    {
        public MainWindow()
        {
            this.Title = "OhSyTe 2024";
            this.Width = 300;
            this.Height = 200;

            // Create a Canvas
            Canvas canvas = new Canvas();

            // Create a TextBlock
            TextBlock textBlock = new TextBlock
            {
                Text = "OhSyTe 2024",
                FontSize = 20,
                Foreground = Brushes.HotPink,
                HorizontalAlignment = Avalonia.Layout.HorizontalAlignment.Center,
                VerticalAlignment = Avalonia.Layout.VerticalAlignment.Center
            };

            // Set the position of the TextBlock inside the Canvas
            Canvas.SetLeft(textBlock, 50);
            Canvas.SetTop(textBlock, 50);

            // Add the TextBlock to the Canvas
            canvas.Children.Add(textBlock);

            // Set the Canvas as the content of the MainWindow
            this.Content = canvas;

            this.WindowStartupLocation = WindowStartupLocation.CenterScreen;
        }
    }

    class Program
    {
        public static void Main(string[] args)
        {
            BuildAvaloniaApp().StartWithClassicDesktopLifetime(args);
        }

        public static AppBuilder BuildAvaloniaApp()
        {
            return AppBuilder.Configure<App>()
                .UsePlatformDetect()
                .LogToTrace();
        }
    }
}
