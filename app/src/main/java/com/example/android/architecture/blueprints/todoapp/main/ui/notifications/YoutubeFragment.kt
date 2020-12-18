package com.example.android.architecture.blueprints.todoapp.main.ui.notifications

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.architecture.blueprints.todoapp.R


class YoutubeFragment : Fragment() {

    private lateinit var youtubeViewModel: YoutubeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        youtubeViewModel =
                ViewModelProvider(this).get(YoutubeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        youtubeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val web = root.findViewById<WebView>(R.id.webview_youtube)
        //web.settings.javaScriptEnabled = true
        web.settings.javaScriptCanOpenWindowsAutomatically = false
        //web.settings.setPluginsEnabled(true)
        web.settings.setSupportMultipleWindows(false)
        web.settings.setSupportZoom(false)
        web.settings.setAppCacheEnabled(true)
        web.webChromeClient = WebChromeClient()
        web.isVerticalScrollBarEnabled = false
        web.isHorizontalScrollBarEnabled = false

        val URL = "<html><body>Video From YouTube<br>" +
        //"<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/iUf4KJCMEZY\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>" +
        "<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3956.465853158617!2d99.62900731465318!3d7.41358129465117!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x304d9403ca257393%3A0x2e2e08606aecd258!2z4Liq4Liz4LiZ4Lix4LiB4Lin4Li04Lib4Lix4Liq4Liq4LiZ4Liy4Lie4Lix4LiS4LiZ4Liy4LiX4Liy4LiH4LiI4Li04LiVIFZpcGFzc2FuYSBNZWRpdGF0aW9uIFBsYWNlIEZvciBNaW5kIERldm9sb3BtZW50!5e0!3m2!1sen!2sth!4v1608202078886!5m2!1sen!2sth\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\" aria-hidden=\"false\" tabindex=\"0\"></iframe>"+
        "</body></html>"
        //web.loadData(URL, "text/html", "utf-8")
        web.loadUrl("https://web.facebook.com/mtt4.dhamma/?ref=page_internal")

        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return if (url.startsWith("vnd.youtube")) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    true
                } else {
                    false
                }
            }
        }

        return root
    }
}