public class SingleShotImageView extends ImageView {

    public SingleShotImageView(Context context) {
        super(context);
    }

    public SingleShotImageView(Context context, AttributeSet attrs) {
        super(context, attrs);    }

    public SingleShotImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDetachedFromWindow () {
        setImageDrawable(null);
        setBackgroundDrawable(null);
        setImageBitmap(null);
        System.gc();
    }

}