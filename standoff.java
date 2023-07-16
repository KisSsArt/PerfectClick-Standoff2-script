// standoff2 market script

// update this yourself
Point update_button = Point.get(719, 365);
Point confirm_button = Point.get(931, 716);
Point buy_button = Point.get(1715, 470);

Point sticker_top = Point.get(1141, 453);
Point sticker_bottom = Point.get(1263, 487);
//

int step = 115;

long time = Time.getMillis();

startScreenCapture(2);

sleep(200);

while (!EXIT)
{
    for (int line = 0; line < 4; line++)
    {
        Point top = Point.get(sticker_top.x, sticker_top.y + step * line);
        Point bottom = Point.get(sticker_bottom.x, sticker_bottom.y + step * line);

        Point center = Point.get(1243, 472); // third sticker

        if (getContoursCount(top, bottom) > 3 && !(getColor(center) > 14000000 && getColor(center) < 15000000))
        {
            click(Point.get(buy_button.x, buy_button.y + step * line));
            sleepRand(450, 550);
            click(confirm_button);

            EXIT = true;
            break;
        }
    }

    if ((Time.getMillis() - time) > rand(3000, 5000)) 
    {
        click(update_button);
        sleepRand(150, 250);
        click(update_button);

        while (getColor(buy_button) > 11000000)
            sleep(200);

        time = Time.getMillis();
    }

    sleep(50);
}