using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace PhilAPPines
{

    [Activity(Label = "Luzon")]
    public class Luzon : Activity
    {
        Button CBZN, CAR, CL;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.Luzon);
            CBZN = FindViewById<Button>(Resource.Id.button1);
            CAR = FindViewById<Button>(Resource.Id.button2);
            CL = FindViewById<Button>(Resource.Id.button3);
            CBZN.Click += CBZN_Click;
            CAR.Click += CAR_Click;
            CL.Click += CL_Click;
            // Create your application here
        }
        private void CL_Click(object sender, System.EventArgs e)
        {
            Intent CLpage = new Intent(this, typeof(CENTRALLUZON));
            StartActivity(CLpage);
        }

        private void CAR_Click(object sender, System.EventArgs e)
        {
            Intent CARpage = new Intent(this, typeof(CAR));
            StartActivity(CARpage);
        }

        private void CBZN_Click(object sender, System.EventArgs e)
        {
            Intent CBZNpage = new Intent(this, typeof(CALABARZON));
            StartActivity(CBZNpage);
        }
    }
}
