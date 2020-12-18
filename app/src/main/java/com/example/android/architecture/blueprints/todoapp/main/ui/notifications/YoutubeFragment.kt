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
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.main.presenter.WebViewController


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
        val webViewController = WebViewController()
        activity?.let { webViewController.setupWebView(web, it) }

        return root
    }


}