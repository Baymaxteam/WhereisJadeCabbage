# WhereisJadeCabbage

## Detecting Jade Cabbage by using Tensorflow 

### Command:

Retraining Model (mobilenet 0.25)
```
python tensorflow/examples/image_retraining/retrain.py \
    --image_dir /Users/sam/Desktop/dataset/ \
    --learning_rate=0.0001 \
    --testing_percentage=20 \
    --validation_percentage=20 \
    --train_batch_size=32 \
    --validation_batch_size=-1 \
    --flip_left_right True \
    --random_scale=30 \
    --random_brightness=30 \
    --eval_step_interval=100 \
    --how_many_training_steps=600 \
    --architecture mobilenet_0.25_128
```

Validate Result
```
python tensorflow/examples/label_image/label_image.py --graph /tmp/output_graph.pb --labels /tmp/output_labels.txt \
    --image /Users/sam/Downloads/IMG_8015.JPG \
    --input_layer=input \
    --output_layer=final_result \
    --input_mean=128 \
    --input_std=128 \
    --input_width=128 \
    --input_height=128
```
