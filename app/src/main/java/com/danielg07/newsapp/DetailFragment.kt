package com.danielg07.newsapp

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val art = DetailFragmentArgs.fromBundle(requireArguments()).article
        val titulo: TextView = view.findViewById(R.id.tvTitleDetail)
        val autor: TextView = view.findViewById(R.id.tvAutorPubliDetail)
        val contenido: TextView = view.findViewById(R.id.tvContenidoDetail)
        val fecha: TextView = view.findViewById(R.id.tvFechaDetail)
        val img: ImageView = view.findViewById(R.id.ivfoto)

        titulo.text = art.title
        autor.text = getString(R.string.template_autor_publicador, art.author, art.source.name)
        contenido.text = art.content
        fecha.text = art.publishedAt

        img.load(art.urlToImage)
    }
}