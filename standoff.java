// standoff2 market script

// update this yourself
Point update_button = Point.get(719, 365);
Point confirm_button = Point.get(931, 716);

Point sticker_top = Point.get(1141, 453);
Point sticker_bottom = Point.get(1263, 487);

int step = 115;

Point[] buy_buttons = { 
    Point.get(1568, 506),
    Point.get(1568, 622), 
    Point.get(1568, 733), 
    Point.get(1568, 852)
};

long time = Time.getMillis();

startScreenCapture(2);

sleep(200);

while (!EXIT)
{
    Point top = sticker_top;
    Point bottom = sticker_bottom;

    for (int line = 0; line < buy_buttons.length; line++)
    {
        if (getContoursCount(top, bottom) > 3)
        {
            click(buy_buttons[line]);
            sleepRand(450, 550);
            click(confirm_button);
            break;
        }

        top.y += step;
        bottom.y += step;
    }

    if ((Time.getMillis() - time) > rand(3000, 5000)) 
    {
        click(update_button);
        sleepRand(150, 250);
        click(update_button);

        while (getColor(buy_buttons[0]) > 11000000)
            sleep(200);

        time = Time.getMillis();
    }

    sleep(50);
}