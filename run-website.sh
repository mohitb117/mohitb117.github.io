#!/bin/bash
#
# ============================================
# Mohit Bhalla's Personal Website Script
# ============================================
#
# This script builds the Jekyll website and provides instructions
# for running it locally.
#
# Usage:
#   ./run-website.sh        - Build the site
#   ./run-website.sh serve  - Build and start local server
#
# ============================================

# Add Homebrew Ruby to PATH (required for Jekyll on macOS)
export PATH="/opt/homebrew/opt/ruby/bin:$PATH"

# Navigate to site directory
cd ~/workspaces/mohitb117.github.io

# Check if serving or just building
if [ "$1" = "serve" ]; then
    echo "=============================================="
    echo "Starting Jekyll development server..."
    echo ""
    echo "Server will run at:"
    echo "  http://localhost:4000"
    echo ""
    echo "Open in Chrome with:"
    echo "  open -a \"Google Chrome\" http://localhost:4000"
    echo "=============================================="
    echo ""
    
    # Start Jekyll server with live reload
    bundle exec jekyll serve --livereload
else
    # Build the site incrementally
    echo "=============================================="
    echo "Building Jekyll website..."
    echo "=============================================="
    bundle exec jekyll build --incremental
    echo ""
    echo "Build complete!"
    echo ""
    echo "=============================================="
    echo "To run locally with live reload:"
    echo "  ./run-website.sh serve"
    echo ""
    echo "Then open Chrome and navigate to:"
    echo "  http://localhost:4000"
    echo ""
    echo "Or use this command to auto-open Chrome:"
    echo "  open -a \"Google Chrome\" http://localhost:4000"
    echo "=============================================="
fi
