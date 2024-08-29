import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mtbazaar.R
import com.example.mtbazaar.databinding.ViewholderColorBinding

class ColorAdapter(private val items: List<String>) :
    RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    private var selectedPosition = -1

    class ViewHolder(val binding: ViewholderColorBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(items[position])
            .into(holder.binding.pic)

        holder.binding.root.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)
        }

        holder.binding.colorLayout.setBackgroundResource(
            if (selectedPosition == position) R.drawable.grey_bg_selected
            else R.drawable.grey_bg
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
