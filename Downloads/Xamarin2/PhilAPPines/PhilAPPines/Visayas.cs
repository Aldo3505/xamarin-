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
    [Activity(Label = "Visayas")]
    public class Visayas : Activity
    {
        ImageButton WVIS, CVIS, Sun;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.Visayas);
            Sun = FindViewById<ImageButton>(Resource.Id.imageButtonSUN);
            WVIS = FindViewById<ImageButton>(Resource.Id.imageButtonWV);
            CVIS = FindViewById<ImageButton>(Resource.Id.imageButtonCV);
            WVIS.Click += WVIS_Click;
            CVIS.Click += CVIS_Click;
        }

        private void WVIS_Click(object sender, System.EventArgs e)
        {
            Intent WVISpage = new Intent(this, typeof(WESTERNVISAYAS));
            StartActivity(WVISpage);
        }

        private void CVIS_Click(object sender, System.EventArgs e)
        {
            Intent CVISpage = new Intent(this, typeof(CVISAYAS));
            StartActivity(CVISpage);
        }

    }
}

