package info.curtbinder.providertest;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/*
 * This is a simple activity.  It just displays a button, 2 radio buttons
 * and a text box.  The text box just displays a list of all the log dates
 * from the database.
 * 
 * The additional information about the ContentProvider is accurate as of
 * version 0.8.0 of Reef Angel Status
 */
public class ProviderTester extends Activity implements OnClickListener {

	TextView tv;
	Button btn;
	RadioGroup rg;

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		// Set the xml layout file
		setContentView( R.layout.main );

		// grab handles to the controls for easy referencing
		tv = (TextView) findViewById( R.id.output );
		btn = (Button) findViewById( R.id.button1 );
		rg = (RadioGroup) findViewById( R.id.radioGroup1 );

		// set the onclick handler for the button press
		btn.setOnClickListener( this );
	}

	private void displayProvider ( ) {
		// clear the current text box
		tv.setText( "" );

		// create the URI for the Reef Angel Status Provider
		// this is the base content string of the provider
		String myUri = "content://info.curtbinder.reefangel.db/";
		int id = rg.getCheckedRadioButtonId();
		/*
		 * There are only 3 choices for data from the database
		 * 
		 * latest - gets the latest data status - gets all the data status/# -
		 * gets a specific item / record
		 * 
		 * To use, your content string will be:
		 * 
		 * Get the latest: content://info.curtbinder.reefangel.db/latest
		 * 
		 * Get all the data: content://info.curtbinder.reefangel.db/status
		 * 
		 * Get the 3rd row of data:
		 * content://info.curtbinder.reefangel.db/status/3
		 */
		// based on the radio button, adjust what data is requested
		// This example only shows the latest data or all the data
		if ( id == R.id.radio0 )
			myUri += "latest";
		else
			myUri += "status";
		try {
			Uri CONTENT_URI = Uri.parse( myUri );
			// get the content resolver based on the Uri
			ContentResolver cr = getContentResolver();
			// query the data provider with the content Uri
			/*
			 * The provider is very simple. It does not make use of any of the
			 * other parameters of the query command. They are simply ignored.
			 * The data returned is based on the content Uri.
			 */
			Cursor c = cr.query( CONTENT_URI, null, null, null, null );
			// you can either use startManagingCursor to handle the cursor for
			// you
			// this will close it automatically when the activity closes and
			// handle
			// refreshing the data if it's bound to a list
			// otherwise just close the cursor when you finish getting the data
			// startManagingCursor(c);
			StringBuilder sb = new StringBuilder();
			// move the cursor to the first item in the list
			if ( c.moveToFirst() ) {
				do {
					// work with the data
					/*
					 * Here are the columns in the database:
					 * _id,t1,t2,t3,ph,dp,ap
					 * ,atohi,atolow,sal,orp,logdate,rdata,ronmask
					 * ,roffmask,r1data
					 * ,r1onmask,r1offmask,r2data,r2onmask,r2offmask
					 * ,r3data,r3onmask
					 * ,r3offmask,r4data,r4onmask,r4offmask,r5data
					 * ,r5onmask,r5offmask
					 * ,r6data,r6onmask,r6offmask,r7data,r7onmask
					 * ,r7offmask,r8data
					 * ,r8onmask,r8offmask,pwme0,pwme1,pwme2,pwme3
					 * ,pwme4,pwme5,aiw
					 * ,aib,airb,rfm,rfs,rfd,rfw,rfrb,rfr,rfg,rfb
					 * ,rfi,io,c0,c1,c2,c3,c4,c5,c6,c7,em,rem,phe,wl
					 * 
					 * The best way to reference the data is like below.
					 * Use the c.getColumnIndex(COLUMN_NAME) and then do
					 * a c.getString() on that.  Most of the data is stored
					 * as an INTEGER but getString works just fine on those fields
					 */
					sb.append( c.getString( c.getColumnIndex( "logdate" ) ) )
							.append( "\n" );
					// the while loop is only useful if you are working with
					// all the data.  it is not necessary for the latest data
					// or an individual entry
				} while ( c.moveToNext() );
			}
			// close the cursor from the database
			c.close();
			
			// update the screen with the data
			tv.setText( sb );
		} catch ( Exception e ) {
			e.printStackTrace();
			tv.setText( "Error accessing data\n" + e.getMessage() );
		}
	}

	@Override
	public void onClick ( View v ) {
		// tap the button, display the results
		displayProvider();
	}
}
