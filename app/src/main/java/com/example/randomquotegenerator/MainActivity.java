package com.example.randomquotegenerator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set background color
        View root = findViewById(R.id.main);
        root.setBackgroundColor(getResources().getColor(R.color.background));
        // Optional: Elevate CardView for shadow
        CardView cardView = findViewById(R.id.quoteCard);
        cardView.setCardElevation(12f);
        // Optional: Make button background rounded (already set in XML)

        // Quote data
        final Quote[] quotes = new Quote[] {
                new Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
                new Quote("Success is not the key to happiness. Happiness is the key to success.", "Albert Schweitzer"),
                new Quote("In the middle of every difficulty lies opportunity.", "Albert Einstein"),
                new Quote("What you get by achieving your goals is not as important as what you become by achieving your goals.", "Zig Ziglar"),
                new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
                new Quote("The best way to predict the future is to invent it.", "Alan Kay"),
                new Quote("It does not matter how slowly you go as long as you do not stop.", "Confucius"),
                new Quote("You miss 100% of the shots you don't take.", "Wayne Gretzky"),
                new Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"),
                new Quote("Do not wait to strike till the iron is hot; but make it hot by striking.", "William Butler Yeats"),
                new Quote("Everything you've ever wanted is on the other side of fear.", "George Addair"),
                new Quote("Opportunities don't happen, you create them.", "Chris Grosser"),
                new Quote("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"),
                new Quote("If you want to lift yourself up, lift up someone else.", "Booker T. Washington"),
                new Quote("Strive not to be a success, but rather to be of value.", "Albert Einstein"),
                new Quote("Act as if what you do makes a difference. It does.", "William James"),
                new Quote("Happiness is not something ready made. It comes from your own actions.", "Dalai Lama"),
                new Quote("The only limit to our realization of tomorrow is our doubts of today.", "Franklin D. Roosevelt"),
                new Quote("Dream big and dare to fail.", "Norman Vaughan"),
                new Quote("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"),
                new Quote("What lies behind us and what lies before us are tiny matters compared to what lies within us.", "Ralph Waldo Emerson"),
                new Quote("Keep your face always toward the sunshine—and shadows will fall behind you.", "Walt Whitman"),
                new Quote("The best revenge is massive success.", "Frank Sinatra"),
                new Quote("Difficulties in life are intended to make us better, not bitter.", "Dan Reeves"),
                new Quote("The harder you work for something, the greater you'll feel when you achieve it.", "Unknown")
        };
        final Random random = new Random();

        TextView quoteTextView = findViewById(R.id.quoteTextView);
        TextView authorTextView = findViewById(R.id.authorTextView);
        Button newQuoteButton = findViewById(R.id.newQuoteButton);

        // Beautiful background color palette
        final int[] bgColors = new int[] {
                getResources().getColor(R.color.background),
                Color.parseColor("#FFF8E1"), // light yellow
                Color.parseColor("#E1F5FE"), // light blue
                Color.parseColor("#F1F8E9"), // light green
                Color.parseColor("#FCE4EC"), // light pink
                Color.parseColor("#EDE7F6"), // light purple
                Color.parseColor("#FFF3E0")  // light orange
        };

        // Helper to show a random quote
        Runnable showRandomQuote = () -> {
            int idx = random.nextInt(quotes.length);
            quoteTextView.setText('"' + quotes[idx].text + '"');
            authorTextView.setText("- " + quotes[idx].author);
            // Change background color
            int colorIdx = random.nextInt(bgColors.length);
            root.setBackgroundColor(bgColors[colorIdx]);
            // Always set button color to blue
            newQuoteButton.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#1976D2")));
        };

        // Show a quote on launch
        showRandomQuote.run();

        newQuoteButton.setOnClickListener(v -> showRandomQuote.run());
    }

    // Quote class
    static class Quote {
        String text;
        String author;
        Quote(String text, String author) {
            this.text = text;
            this.author = author;
        }
    }
}