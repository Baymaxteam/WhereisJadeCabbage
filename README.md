# WhereisJadeCabbage

## Detecting Jade Cabbage App Demo

![alt text](https://github.com/Baymaxteam/WhereisJadeCabbage/blob/master/Demo.PNG)

## Detecting Jade Cabbage by using Tensorflow 

### Command:

Retraining Model (mobilenet 0.25)
```
python tensorflow/examples/image_retraining/retrain.py \
    --image_dir /Users/sam/Desktop/dataset/ \
    --learning_rate=0.0001 \
    --testing_percentage=10 \
    --validation_percentage=10 \
    --train_batch_size=32 \
    --validation_batch_size=-1 \
    --flip_left_right True \
    --random_scale=30 \
    --random_brightness=30 \
    --eval_step_interval=10 \
    --how_many_training_steps=150 \
    --architecture mobilenet_0.25_224
```

Validate Result
```
python tensorflow/examples/label_image/label_image.py --graph /tmp/output_graph.pb --labels /tmp/output_labels.txt \
    --image /Users/sam/Downloads/IMG_8015.JPG \
    --input_layer=input \
    --output_layer=final_result \
    --input_mean=128 \
    --input_std=128 \
    --input_width=224 \
    --input_height=224
```
