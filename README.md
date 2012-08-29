This is an example application for an activity referencing the Reef Angel Status content provider.
The information listed is accurate as of Reef Angel Status version 0.8.0.

The app contains comments with how to add permissions to your app for reading the data.
This must be added to AndroidManifest.xml.
<uses-permission android:name="info.curtbinder.reefangel.permission.READ_PROVIDER" />
Look in AndroidManifest.xml for details.

There are comments about accessing and displaying the data.
Inside ProviderTester.java, there are comments to access the data.

In short, you must:
* get the ContentResolver
* create the Content query / Uri
* query the Provider for a cursor of the data
* loop through the data and use the data
* close the cursor

The columns in the database that you have access to inside the cursor are as follows:

public static final String PCOL_ID = "_id";
public static final String PCOL_T1 = "t1";
public static final String PCOL_T2 = "t2";
public static final String PCOL_T3 = "t3";
public static final String PCOL_PH = "ph";
public static final String PCOL_DP = "dp";
public static final String PCOL_AP = "ap";
public static final String PCOL_ATOHI = "atohi";
public static final String PCOL_ATOLO = "atolow";
public static final String PCOL_SAL = "sal";
public static final String PCOL_ORP = "orp";
public static final String PCOL_LOGDATE = "logdate";
public static final String PCOL_RDATA = "rdata";
public static final String PCOL_RONMASK = "ronmask";
public static final String PCOL_ROFFMASK = "roffmask";
public static final String PCOL_R1DATA = "r1data";
public static final String PCOL_R1ONMASK = "r1onmask";
public static final String PCOL_R1OFFMASK = "r1offmask";
public static final String PCOL_R2DATA = "r2data";
public static final String PCOL_R2ONMASK = "r2onmask";
public static final String PCOL_R2OFFMASK = "r2offmask";
public static final String PCOL_R3DATA = "r3data";
public static final String PCOL_R3ONMASK = "r3onmask";
public static final String PCOL_R3OFFMASK = "r3offmask";
public static final String PCOL_R4DATA = "r4data";
public static final String PCOL_R4ONMASK = "r4onmask";
public static final String PCOL_R4OFFMASK = "r4offmask";
public static final String PCOL_R5DATA = "r5data";
public static final String PCOL_R5ONMASK = "r5onmask";
public static final String PCOL_R5OFFMASK = "r5offmask";
public static final String PCOL_R6DATA = "r6data";
public static final String PCOL_R6ONMASK = "r6onmask";
public static final String PCOL_R6OFFMASK = "r6offmask";
public static final String PCOL_R7DATA = "r7data";
public static final String PCOL_R7ONMASK = "r7onmask";
public static final String PCOL_R7OFFMASK = "r7offmask";
public static final String PCOL_R8DATA = "r8data";
public static final String PCOL_R8ONMASK = "r8onmask";
public static final String PCOL_R8OFFMASK = "r8offmask";
public static final String PCOL_PWME0 = "pwme0";
public static final String PCOL_PWME1 = "pwme1";
public static final String PCOL_PWME2 = "pwme2";
public static final String PCOL_PWME3 = "pwme3";
public static final String PCOL_PWME4 = "pwme4";
public static final String PCOL_PWME5 = "pwme5";
public static final String PCOL_AIW = "aiw";
public static final String PCOL_AIB = "aib";
public static final String PCOL_AIRB = "airb";
public static final String PCOL_RFM = "rfm";
public static final String PCOL_RFS = "rfs";
public static final String PCOL_RFD = "rfd";
public static final String PCOL_RFW = "rfw";
public static final String PCOL_RFRB = "rfrb";
public static final String PCOL_RFR = "rfr";
public static final String PCOL_RFG = "rfg";
public static final String PCOL_RFB = "rfb";
public static final String PCOL_RFI = "rfi";
public static final String PCOL_IO = "io";
public static final String PCOL_C0 = "c0";
public static final String PCOL_C1 = "c1";
public static final String PCOL_C2 = "c2";
public static final String PCOL_C3 = "c3";
public static final String PCOL_C4 = "c4";
public static final String PCOL_C5 = "c5";
public static final String PCOL_C6 = "c6";
public static final String PCOL_C7 = "c7";
public static final String PCOL_EM = "em";
public static final String PCOL_REM = "rem";
public static final String PCOL_PHE = "phe";
public static final String PCOL_WL = "wl";

You can copy this text to your application or just use the actual string name for the columns.

