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

namespace Visayas
{
    [Activity(Label = "Visayas", MainLauncher = true)]
    public class MainActivity : Activity
    {
        Button CBZN, CAR, CL;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);
            WVIS = FindViewById<Button>(Resource.Id.button1);
            EVIS = FindViewById<Button>(Resource.Id.button2);
            WVIS.Click += CBZN_Click;
            EVIS.Click += CAR_Click;
        }

        private void WVIS_Click(object sender, System.EventArgs e)
        {
            Intent WVISpage = new Intent(this, typeof(WESTERNVISAYAS));
            StartActivity(WVISpage);
        }

        private void EVIS_Click(object sender, System.EventArgs e)
        {
            Intent EVISpage = new Intent(this, typeof(CAR));
            StartActivity(EVISpage);
        }

    }
}

