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
    [Activity(Label = "CENTRALLUZON")]
    public class CENTRALLUZON : Activity
    {
        ImageButton sun, info, food, people, sites;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.CENTRALLUZON);
            sun = FindViewById<ImageButton>(Resource.Id.imageButton1);
            info = FindViewById<ImageButton>(Resource.Id.imageButton6);
            //There is no image button2
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
            Intent PLACES = new Intent(this, typeof(CLPLACES));
            StartActivity(PLACES);
        }

        private void People_Click(object sender, EventArgs e)
        {
            Intent PPL = new Intent(this, typeof(CLPPL));
            StartActivity(PPL);
        }

        private void Food_Click(object sender, EventArgs e)
        {
            Intent FOOD = new Intent(this, typeof(CLFOOD));
            StartActivity(FOOD);
        }

        private void Info_Click(object sender, EventArgs e)
        {
            Intent INFO = new Intent(this, typeof(CLINFO));
            StartActivity(INFO);
        }
    }
}