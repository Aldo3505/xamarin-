
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
        Button NMIN;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.Mindanao);
            NMIN = FindViewById<Button>(Resource.Id.button1);
            NMIN.Click += NMIN_Click;
            // Create your application here
        }

        private void NMIN_Click (object sender, System.EventArgs e)
        {
            Intent NMINpage = new Intent(this, typeof(NORTHERNMINDANAO));
            StartActivity(NMINpage);
        }
    }
}
