package facci.guillermoduran.practica4;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class TareasRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //Arreglo de items a mostrar en el RecyclerView
    private ArrayList<String> items;
    private ArrayList<String> status;
    private int image[];
    //Formato de texto en negrita
    Typeface fontBold;
    Context mContext;
    //Constantes para controlar la ubicacion de los titulos y de los items
    private final int ITEM = 0, TITLE = 1;

    //Constructor para items y contexto
    public TareasRecyclerViewAdapter(Context context, ArrayList<String> items, ArrayList<String> status, int[] image){
        mContext = context;
        this.items = items;
        this.status = status;
        this.image = image;
    }


    //Obtener el tamano de la lista

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    //Vista a mostrar segun posicion del item

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TITLE;
        }else {
            return ITEM;
        }
    }

    /**
     * Metodo para los holders segun tipo de vista
     * @param viewGroup ViewGroup conteiner del item
     * @param viewType tipo de vista
     * @return viewHolder  que se inflara
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType){
            case ITEM:
                View v1 = inflater.inflate(R.layout.recycler_item, viewGroup, false);
                viewHolder = new ViewHolderItem(v1);
                break;
            case TITLE:
                View v2 = inflater.inflate(R.layout.recycler_title, viewGroup, false);
                viewHolder = new ViewHolderTitulo(v2);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch(viewHolder.getItemViewType()){
            case ITEM:
                ViewHolderItem vh1 = (ViewHolderItem) viewHolder;
                configureViewHolderTitulo(vh1, position);
                break;
            case TITLE:
                ViewHolderTitulo vh2 = (ViewHolderTitulo) viewHolder;
                configureViewHolderItem(vh2, position);
                break;
        }
    }

    private void configureViewHolderTitulo (ViewHolderItem vh1, int position){
        String task = items.get(position);
        String stat = status.get(position);
        int img = image[position];
        if(task != null) {
            vh1.getTaskName().setText(task);
            vh1.getTextStatus().setText(stat);
            vh1.getImageViewTarea().setImageResource(img);
        }
    }

    private void configureViewHolderItem(ViewHolderTitulo vh2, int position){
        String separatorString = items.get(position);
        vh2.getTextViewSeparator().setText(separatorString);
        vh2.getTextViewSeparator().setTypeface(fontBold);
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView TextViewNombreTarea, TextViewEstadoTarea;
        private ImageView ImageViewTarea;

        public ViewHolderItem(View v){
            super(v);
            TextViewNombreTarea = (TextView) v.findViewById(R.id.task_name);
            TextViewEstadoTarea = (TextView) v.findViewById(R.id.task_status);
            ImageViewTarea = (ImageView) v.findViewById(R.id.iv_icon);
        }

        public TextView getTaskName(){
            return TextViewNombreTarea;
        }

        public void setTaskName(TextView label1){
            this.TextViewNombreTarea = label1;
        }

        public TextView getTextStatus(){
            return TextViewEstadoTarea;
        }

        public void setTextStatus(TextView textView){
            this.TextViewEstadoTarea = textView;
        }

        public ImageView getImageViewTarea(){
            return ImageViewTarea;
        }

        public void setImageViewTarea(ImageView ImageViewTarea){
            this.ImageViewTarea = ImageViewTarea;
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
        }
    }

    //Objeto ViewHolder para evitar utilizar findViewById()
    public class ViewHolderTitulo extends RecyclerView.ViewHolder {
        TextView TextViewTitulo;

        public ViewHolderTitulo(View v){
            super(v);
            TextViewTitulo = v.findViewById(R.id.tvSeparator);
        }

        public TextView getTextViewSeparator(){
            return TextViewTitulo;
        }

        public void setTextViewSeparator(TextView separator){
            this.TextViewTitulo = separator;
        }
    }

    /*public class ViewHolderStatus extends RecyclerView.ViewHolder{
        TextView textViewStatus;

        public ViewHolderStatus(View v) {
            super(v);
            textViewStatus = v.findViewById(R.id.task_status);
        }

        public TextView getTextViewStatus(){
            return textViewStatus;
        }

        public void setTextViewStatus(TextView textViewStatus){
            this.textViewStatus = textViewStatus;
        }
    }

    public class ViewHolderImagen extends RecyclerView.ViewHolder{
        ImageView imageViewPersonaje;

        public ViewHolderImagen(View itemView) {
            super(itemView);
            imageViewPersonaje = itemView.findViewById(R.id.iv_icon);
        }

        public ImageView getImageViewPersonaje(){
            return imageViewPersonaje;
        }

        public void setImageViewPersonaje(ImageView imageViewPersonaje){
            this.imageViewPersonaje = imageViewPersonaje;
        }
    }*/
}
