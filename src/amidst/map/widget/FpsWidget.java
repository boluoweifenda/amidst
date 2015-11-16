package amidst.map.widget;

import java.awt.Graphics2D;

import amidst.Options;
import amidst.map.MapViewer;
import amidst.utilities.FramerateTimer;

public class FpsWidget extends PanelWidget {
	private FramerateTimer fpsTimer = new FramerateTimer(2);

	public FpsWidget(MapViewer mapViewer) {
		super(mapViewer);
		setSize(20, 30);
		forceVisibility(onVisibilityCheck());
	}

	@Override
	public void draw(Graphics2D g2d, float time) {
		String framerate = fpsTimer.toString();
		fpsTimer.tick();
		setWidth(mapViewer.getFontMetrics().stringWidth(framerate) + 20);
		super.draw(g2d, time);
		g2d.setColor(TEXT_COLOR);
		g2d.drawString(framerate, getX() + 10, getY() + 20);
	}

	@Override
	protected boolean onVisibilityCheck() {
		return Options.instance.showFPS.get();
	}
}
