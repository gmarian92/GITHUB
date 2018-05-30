package com.example.marian.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/


         import android.app.Notification;
         import android.content.Intent;
         import android.net.Uri;
         import android.os.Bundle;
         import android.provider.AlarmClock;
         import android.support.v7.app.AppCompatActivity;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.EditText;
         import android.widget.TextView;

         import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view){
        if (quantity <= 99) {
            quantity++;
        }
        displayQuantity( quantity);
    }
    public void decrement(View view){
        if (quantity >=2) {
            quantity--;
        }
        displayQuantity( quantity);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameTextView = (EditText) findViewById(R.id.customer_name);
        String customerName=nameTextView.getText().toString();

        CheckBox boxWhippedCream = (CheckBox) findViewById(R.id.wCream);
        boolean isWhippedCream = boxWhippedCream.isChecked();


        CheckBox boxChocolate = (CheckBox) findViewById(R.id.chocolateBox);
        boolean isChocolate = boxChocolate.isChecked();
        int price = calculatePrice(isWhippedCream , isChocolate );

        String priceMessage=createOrderSummary(customerName, quantity, isWhippedCream, isChocolate);



    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private String createOrderSummary(String customerName, int quantity, boolean isWhippedCream, boolean isChocolate ){

        String summary=getString(R.string.name)+":"+customerName;
        summary+="\n"+getString(R.string.add_whippedcream)+isWhippedCream;
        summary+="\n"+getString(R.string.add_chocolate)+isChocolate;
        summary+="\n"+getString(R.string.Quantity)+":"+quantity;
        summary+="\n" + getString(R.string.total)+":"+calculatePrice(isWhippedCream, isChocolate)+ "$";
        summary+="\n"+getString(R.string.thank_you);
        composeEmail(customerName, summary);
        return " ";

    }

    public void composeEmail(String customerName, String summary) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for "+ customerName);
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private int calculatePrice(boolean isWhippedCream, boolean isChocolate ) {
        int basePrice = 5;
        if (isWhippedCream) {
            basePrice = basePrice + 1;
        }
        if (isChocolate) {
            basePrice =  basePrice + 2;
        }
            int price = quantity * basePrice;

        return price;
    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numbers);
    }

    /**
     * This method displays the given text on the screen.
 */

}