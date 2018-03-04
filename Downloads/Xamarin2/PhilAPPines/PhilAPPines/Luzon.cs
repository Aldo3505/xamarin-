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
        ImageButton CBZN, CAR, CL, Sun;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.Luzon);
            Sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            CBZN = FindViewById<ImageButton>(Resource.Id.imageButton2);
            CAR = FindViewById<ImageButton>(Resource.Id.imageButton3);
            CL = FindViewById<ImageButton>(Resource.Id.imageButton4);
            Sun.Click += Sun_Click;
            CBZN.Click += CBZN_Click;
            CAR.Click += CAR_Click;
            CL.Click += CL_Click;
            // Create your application here
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
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
