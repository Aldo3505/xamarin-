
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
    [Activity(Label = "Mindanao")]
    public class Mindanao : Activity
    {
        ImageButton NMIN, Sun;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.Mindanao);
            Sun = FindViewById<ImageButton>(Resource.Id.imageButton3);
            NMIN = FindViewById<ImageButton>(Resource.Id.imageButton2);
            NMIN.Click += NMIN_Click;
            Sun.Click += Sun_Click;
            // Create your application here
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
        }

        private void NMIN_Click (object sender, System.EventArgs e)
        {
            Intent NMINpage = new Intent(this, typeof(NORTHERNMINDANAO));
            StartActivity(NMINpage);
        }
    }
}
