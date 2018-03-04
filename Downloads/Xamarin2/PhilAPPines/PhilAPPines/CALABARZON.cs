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
    [Activity(Label = "CALABARZON")]
    public class CALABARZON : Activity
    {
        ImageButton sun, info, food, people, sites;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.CALABARZON);
            sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            info = FindViewById<ImageButton>(Resource.Id.imageButton6);
            food = FindViewById<ImageButton>(Resource.Id.imageButton3);
            people = FindViewById<ImageButton>(Resource.Id.imageButton4);
            sites = FindViewById<ImageButton>(Resource.Id.imageButton5);
            sun.Click += Sun_Click;
            info.Click += Info_Click;
            food.Click += Food_Click;
            people.Click += People_Click;
            sites.Click += Sites_Click;
        }

        private void Sun_Click(object sender, EventArgs e)
        {
            Intent HomePage = new Intent(this, typeof(MainActivity));
            StartActivity(HomePage);
        }

        private void Sites_Click(object sender, EventArgs e)
        {
            Intent SITESCBZNpage = new Intent(this, typeof(CBZNPLACES));
            StartActivity(SITESCBZNpage);
        }

        private void People_Click(object sender, EventArgs e)
        {
            Intent PEOPLECBZNpage = new Intent(this, typeof(CBZNPPL));
            StartActivity(PEOPLECBZNpage);
        }

        private void Food_Click(object sender, EventArgs e)
        {
            Intent FOODCBZNpage = new Intent(this, typeof(CBZNFOOD));
            StartActivity(FOODCBZNpage);
        }

        private void Info_Click(object sender, EventArgs e)
        {
            Intent INFOCBZNpage = new Intent(this, typeof(CBZNFOOD));
            StartActivity(INFOCBZNpage);
        }
    }
}